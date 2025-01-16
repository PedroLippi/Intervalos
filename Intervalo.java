public class Intervalo {
    private int inf; // Limite inferior
    private int sup; // Limite superior
    private boolean fechInf; // Indica se o limite inferior é fechado
    private boolean fechSup; // Indica se o limite superior é fechado

    // Construtor
    public Intervalo(int inf, int sup, boolean fechInf, boolean fechSup) {
        if (inf > sup) {
            throw new IllegalArgumentException("O limite inferior deve ser menor ou igual ao limite superior.");
        }
        this.inf = inf;
        this.sup = sup;
        this.fechInf = fechInf;
        this.fechSup = fechSup;
    }

    // Verifica se o valor está contido no intervalo
    public boolean contem(int val) {
        boolean maiorOuIgual;
        if (fechInf) {
            maiorOuIgual = val >= inf;
        } else {
            maiorOuIgual = val > inf;
        }

        boolean menorOuIgual;
        if (fechSup) {
            menorOuIgual = val <= sup;
        } else {
            menorOuIgual = val < sup;
        }

        return maiorOuIgual && menorOuIgual;
    }

    // Verifica se há interseção entre dois intervalos
    public boolean intercepta(Intervalo outro) {
        return !(outro.sup < inf || outro.inf > sup);
    }

    // Calcula a média dos valores pertencentes ao intervalo
    public float media() {
        int inicio = fechInf ? inf : inf + 1;
        int fim = fechSup ? sup : sup - 1;

        if (inicio > fim) {
            throw new IllegalStateException("Intervalo vazio, não é possível calcular a média.");
        }

        int soma = 0;
        int qtd = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += i;
            qtd++;
        }
        return soma / qtd;
    }

    // Calcula o produto de dois intervalos
    public Intervalo produto(Intervalo outro) {
        int p1 = inf * outro.inf;
        int p2 = inf * outro.sup;
        int p3 = sup * outro.inf;
        int p4 = sup * outro.sup;

        int novoInf = Math.min(Math.min(p1, p2), Math.min(p3, p4));
        int novoSup = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        return new Intervalo(novoInf, novoSup, true, true);
    }

    // Calcula a união de dois intervalos
    public String uniao(Intervalo outro) {
        if (intercepta(outro) || sup == outro.inf || inf == outro.sup) {
            int novoInf = Math.min(inf, outro.inf);
            int novoSup = Math.max(sup, outro.sup);

            boolean novoFechInf = (inf < outro.inf) ? fechInf : outro.fechInf;
            boolean novoFechSup = (sup > outro.sup) ? fechSup : outro.fechSup;

            return formatarIntervalo(novoInf, novoSup, novoFechInf, novoFechSup);
        }

        String intervaloA = formatarIntervalo(inf, sup, fechInf, fechSup);
        String intervaloB = formatarIntervalo(outro.inf, outro.sup, outro.fechInf, outro.fechSup);
        return intervaloA + " U " + intervaloB;
    }

    // Formatar intervalo de acordo com os limites
    public String formatarIntervalo(int inf, int sup, boolean fechInf, boolean fechSup) {
        String intervalo = "";

        if (fechInf) {
            intervalo += "[" + inf;
        } else {
            intervalo += "(" + inf;
        }

        intervalo += ", ";

        if (fechSup) {
            intervalo += sup + "]";
        } else {
            intervalo += sup + ")";
        }

        return intervalo;
    }

    // Métodos de acesso para obter os limites
    public int getInf() {
        return inf;
    }

    public int getSup() {
        return sup;
    }

    public boolean isFechInf() {
        return fechInf;
    }

    public boolean isFechSup() {
        return fechSup;
    }
}

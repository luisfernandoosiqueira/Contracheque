package modelos;

/**
 *
 * @author Luís Fernando
 */
public class Funcionario {

    private String nome = "";
    private int matricula = 0;
    private int quantidadeDependentes = 0;
    private float salarioBase = 0;
    private int producao = 0;
    private float descontoINSS;
    private float descontoImpostoRenda;
    private float descontoFilhos;
    private float salarioLiquido = 0;

    public Funcionario() {
    }

    public Funcionario(String nome, int matricula, int quantidadeDependentes, float salarioBase, int producao) throws Exception {

        if (matricula <= 0) {
            throw new Exception("Matrícula não pode ser <=0");
        }
        this.matricula = matricula;
        if (nome.isEmpty()) {
            throw new Exception("Nome não pode estar vazio");
        }
        this.nome = nome;
        if (quantidadeDependentes <= 0) {
            throw new Exception("Quantidade de dependentes não pode ser <=0");
        }
        this.quantidadeDependentes = quantidadeDependentes;
        if (salarioBase <= 0) {
            throw new Exception("Salário base não pode ser <=0");
        }
        this.salarioBase = salarioBase;
        if (producao <= 0) {
            throw new Exception("Produção base não pode ser <=0");
        }
        this.producao = producao;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.isEmpty()) {
            throw new Exception("Nome não pode estar vazio");
        }
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws Exception {
        if (matricula <= 0) {
            throw new Exception("Matrícula não pode ser <=0");
        }
        this.matricula = matricula;
    }

    public int getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(int quantidadeDependentes) throws Exception {
        if (quantidadeDependentes <= 0) {
            throw new Exception("Quantidade de dependentes não pode ser <=0");
        }
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) throws Exception {
        if (salarioBase <= 0) {
            throw new Exception("Salário base não pode ser <=0");
        }
        this.salarioBase = salarioBase;
    }

    public int getProducao() {
        return producao;
    }

    public void setProducao(int producao) throws Exception {
        if (producao <= 0) {
            throw new Exception("Produção base não pode ser <=0");
        }
        this.producao = producao;
    }

    public float getDescontoINSS() {
        return descontoINSS;
    }

    public void setDescontoINSS(float descontoINSS) {
        this.descontoINSS = descontoINSS;
    }

    public float getDescontoImpostoRenda() {
        return descontoImpostoRenda;
    }

    public void setDescontoImpostoRenda(float descontoImpostoRenda) {
        this.descontoImpostoRenda = descontoImpostoRenda;
    }

    public float getDescontoFilhos() {
        return descontoFilhos;
    }

    public void setDescontoFilhos(float descontoFilhos) {
        this.descontoFilhos = descontoFilhos;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public float calcularGratificacao() {

        if (producao < 1001) {
            return 500;
        }
        if (producao <= 2001) {
            return 1250;
        }
        return 2250;

    }

    public float calcularSalarioBruto() {

        return salarioBase + calcularGratificacao();

    }

    public float calcularDescontoINSS() {

        if (calcularSalarioBruto() < 1413) {
            return (float) (calcularSalarioBruto() * 0.07);
        }
        if (calcularSalarioBruto() < 2666.69) {
            return (float) (calcularSalarioBruto() * 0.09);
        }
        if (calcularSalarioBruto() < 4000.04) {
            return (float) (calcularSalarioBruto() * 0.12);
        }
        return (float) (calcularSalarioBruto() * 0.14);

    }

    public float calcularDescontoIRPF() {

        if (calcularSalarioBruto() < 2259.21) {
            return 0;
        }
        if (calcularSalarioBruto() < 2826.66) {
            return (float) (calcularSalarioBruto() * 0.075);
        }
        if (calcularSalarioBruto() < 3751.06) {
            return (float) (calcularSalarioBruto() * 0.15);
        }
        if (calcularSalarioBruto() < 4664.69) {
            return (float) (calcularSalarioBruto() * 0.225);
        }
        return (float) (calcularSalarioBruto() * 0.225);

    }

    public float calcularDescontoFilhos() {

        return descontoFilhos = 123 * quantidadeDependentes;

    }

    public float calcularSalarioLiquido() {

        return (calcularSalarioBruto() - calcularDescontoINSS()) - calcularDescontoIRPF() + calcularDescontoFilhos();

    }

}

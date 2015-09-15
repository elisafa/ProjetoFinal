package Modelo;

public class Pessoa {
    private String nome, logradouro, cpf, email, teleResidencial, TelCelular, numero, complemento;
    private int codigo, uf, cidade, sexo, bairro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getBairro() {
        return bairro;
    }

    public void setBairro(int bairro) {
        this.bairro = bairro;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeleResidencial() {
        return teleResidencial;
    }

    public void setTeleResidencial(String teleResidencial) {
        this.teleResidencial = teleResidencial;
    }

    public String getTelCelular() {
        return TelCelular;
    }

    public void setTelCelular(String TelCelular) {
        this.TelCelular = TelCelular;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}

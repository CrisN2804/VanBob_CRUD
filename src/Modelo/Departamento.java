package Modelo;

public class Departamento {
    private int idDepartamento;
    private String departamento;

    public Departamento(int idDepa, String depa) {
        setIdDepartamento(idDepa);
        setDepartamento(depa);
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}

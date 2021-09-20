package logica;

public class Parqueadero {
    //atributos
    private String razonSocial;
    private int numPlazasCarro;
    private int numPlazasMoto;
    private double valorMinutoCarro;
    private double valorMinutoMoto;

    //constructor


    public Parqueadero() {
    }

    public Parqueadero(String razonSocial, int numPlazasCarro, int numPlazasMoto, double valorMinutoCarro, double valorMinutoMoto) {
        this.razonSocial = razonSocial;
        this.numPlazasCarro = numPlazasCarro;
        this.numPlazasMoto = numPlazasMoto;
        this.valorMinutoCarro = valorMinutoCarro;
        this.valorMinutoMoto = valorMinutoMoto;
    }
    //get & setter

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNumPlazasCarro() {
        return numPlazasCarro;
    }

    public void setNumPlazasCarro(int numPlazasCarro) {
        this.numPlazasCarro = numPlazasCarro;
    }

    public int getNumPlazasMoto() {
        return numPlazasMoto;
    }

    public void setNumPlazasMoto(int numPlazasMoto) {
        this.numPlazasMoto = numPlazasMoto;
    }

    public double getValorMinutoCarro() {
        return valorMinutoCarro;
    }

    public void setValorMinutoCarro(double valorMinutoCarro) {
        this.valorMinutoCarro = valorMinutoCarro;
    }

    public double getValorMinutoMoto() {
        return valorMinutoMoto;
    }

    public void setValorMinutoMoto(double valorMinutoMoto) {
        this.valorMinutoMoto = valorMinutoMoto;
    }
}

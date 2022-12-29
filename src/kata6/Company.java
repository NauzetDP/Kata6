package kata6;


public class Company {
        
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    
    public void setBs(String bs) {
        this.bs = bs;
    }
    
    @Override
    public String toString() {
        return " {Nombre:" + name + ", Eslogan:" + catchPhrase + ", Tipo de negocio:" + bs + "}";
    }
}
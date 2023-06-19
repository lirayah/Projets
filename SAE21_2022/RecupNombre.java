
public class RecupNombre {
    private int nombre;

    public RecupNombre(){
        this.nombre=0;
    }

    public void setNombre(int i){
        this.nombre=i;
    }

    public int getNombre(){
        return this.nombre;
    }

    public boolean nombreEnvoye(){
        if(this.nombre==0){
            return false;
        }
        else{
            return true;
        }
    }
}

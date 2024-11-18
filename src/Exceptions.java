import javax.swing.*;
import java.awt.*;

public class Exceptions extends Exception{
    public String msg;

    public Exceptions(String msg) {
        this.msg = msg;
    }
    public void exec(Component p){
        JOptionPane.showMessageDialog(p,msg,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}

import jakarta.transaction.TransactionScoped;
import org.example.controller.EquipoController;
import org.example.entities.EquipoEntity;
import org.example.repository.EquiposRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EquiposTest {
    private final EquiposRepository equipo = new EquiposRepository();

    @Test
    public void setEquipoTest(){
        boolean bool = false;
        Assert.assertEquals(bool, equipo.setEquipo("prueba"));
    }

    @Test
    public void deleteEquipoTest(){

        boolean bool = false; ;
        Assert.assertEquals(bool, equipo.deleteEquipo("prueba"));
    }


}

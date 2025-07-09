package Formatos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class seguridad_InactividadManager {
    private final Timer temporizador;
    private final Runnable accionInactividad;
    private boolean accionEjecutada = false;

    public seguridad_InactividadManager(JFrame frame, int tiempoInactividadMs, Runnable accionInactividad) {
        this.accionInactividad = accionInactividad;

        // Timer que se ejecuta después del tiempo de inactividad
        temporizador = new Timer(tiempoInactividadMs, e -> ejecutarUnaSolaVez());
        temporizador.setRepeats(false);

        // Detectar actividad del mouse o teclado
        Toolkit.getDefaultToolkit().addAWTEventListener(
            new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    if ((event instanceof MouseEvent || event instanceof KeyEvent) && !accionEjecutada) {
                        reiniciarTemporizador();
                    }
                }
            },
            AWTEvent.MOUSE_EVENT_MASK |
            AWTEvent.MOUSE_MOTION_EVENT_MASK |
            AWTEvent.KEY_EVENT_MASK
        );

        // Detener el temporizador automáticamente al cerrar el frame
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                detener();
            }
        });

        temporizador.start();
    }

    private void ejecutarUnaSolaVez() {
        if (!accionEjecutada) {
            accionEjecutada = true;
            temporizador.stop();
            accionInactividad.run();
        }
    }

    public void reiniciarTemporizador() {
        if (!accionEjecutada) {
            temporizador.restart();
        }
    }

    public void detener() {
        temporizador.stop();
        accionEjecutada = true;
    }
}

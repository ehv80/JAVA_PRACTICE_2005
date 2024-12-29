/*
 * Applets
 * Posiblemente, una de las cosas que más
 * contribuyeron al desarrollo de Java fueron
 * los Applets. En este capítulo vamos a ver
 * qué son, para qué sirven y en qué casos
 * es conveniente usarlos.
 */
/*
 * ¿QUÉ SON LOS APPLETS?
 * Los Applets son pequeños programas, comúnmente denominados componentes
 * -ya que se van a embeber en otras aplicaciones-, que se enlazan a una página
 * web.
 * El enlace se logra a través de la etiqueta APPLET de HTML. Cuando el
 * navegador que está levantando nuestra página encuentra esta etiqueta,
 * entiende que debe ejecutar un applet; para ello levanta primero
 * una máquina virtual y solicita los archivos necesarios para la correcta
 * ejecución del applet. Los problemas de esta implementación
 * son los siguientes: la configuración de seguridad del navegador,
 * los applets son pesados, y en una red lenta es posible que
 * no se puedan ejecutar. Por lo tanto, cuando programemos
 * applets deberemos tratar de que sean livianos y que no sean demasiado
 * relevantes para que alguien que no desee ejecutarlos pueda seguir
 * navegando en nuestra página sin problemas.
 */
/*
 * EL APPLETVIEWER
 * El applet asume que el código se está ejecutando desde dentro de un
 * navegador.
 * Para que no dependamos de un navegador, podemos hacer uso del AppletViewer,
 * que tiene el aspecto de un pequeño navegador. Éste espera como argumento el
 * nombre del fichero HTML que debe cargar, no se le puede pasar directamente un
 * programa java. Este fichero HTML debe contener una marca que especifica el
 * código que cargará el AppletViewer.
 * Esta marca, como ya vimos, es la etiqueta APPLET de HTML:
 * 
 * <HTML>
 * <APPLET CODE=PruebaApplet.class WIDTH=300 HEIGHT=100>
 * </APPLET>
 * </HTML>
 * 
 * De esta manera el AppletViewer genera un espacio de navegación con
 * un área gráfica donde se va a ejecutar nuestro applet PruebaApplet.class
 * 
 * <HTML> ------------- Carga la clase ----------------------> [ Class Loader ]
 * <APPLET CODE=HolaMundo.class> _____________________________ [ frame manager ]
 * </APPLET> _________________________________________________ [ init() ]
 * </HTML> ___________________________________________________ [ paint() ]
 * ___________________________________________________________ [ start() ]
 * APPLET <------------ Crea el frame(marco) ----------------- [ stop() ]
 * APPLET ____________________________________________________ [ update() ]
 * APPLET ____________________________________________________ [ destroy() ]
 * APPLET <-------------------------------------[ Objeto Graphics(gráfico) ]
 * Figura 1. Vista del AppletViewer
 */
/*
 * MÉTODOS
 * Antes de entrar de lleno en el código, vamos a ver los métodos propios
 * de la clase Applet y para qué sirven.
 * 
 * · init(): el método init() es llamado cada vez que la clase se carga
 * por primera vez. El applet puede sobrecargar este método para fijar
 * el tamaño del applet, cargar imágenes y sonidos necesarios para la
 * ejecución del applet, y la asignación de valores a las variables
 * globales a la clase que se utilicen.
 * 
 * · start(): su función es hacer que el applet comience la ejecución.
 * El método start() de la clase Applet no hace nada. Cada vez que
 * la zona de visualización del applet queda expuesta, se llama a
 * este método automáticamente, aunque podemos modificarlo para que
 * el applet siga activo aun cuando no está expuesto a la visión.
 * 
 * · stop(): detiene la ejecución del Applet. Al igual que start(),
 * se llama cuando el applet desaparece de la pantalla. Este
 * método también hay que reescribirlo.
 * 
 * ·destroy(): el método destroy() se llama cuando ya no se va a usar
 * más el applet, cuando se necesita que sean liberados todos los
 * recursos dispuestos por el applet; por ejemplo, cuando se cierra
 * el navegador. Como el sistema no sabe qué recursos usa el applet,
 * entonces debemos reescribir este método para liberarlos de
 * forma correcta.
 * 
 * · paint(Graphics g): este método es llamado cada vez que el área
 * de dibujo del applet necesita ser actualizada. La clase Applet
 * dibuja un rectángulo gris en el área, y la clase derivada debe
 * sobrecargar este método para dibujar lo que necesite. El sistema
 * llama en forma automática a este método cada vez que la zona de
 * visualización del applet cambia. Este cambio puede deberse a
 * que la página se refresca, a que el applet queda tapado con otra
 * ventana, queda afuera de la pantalla, etc. El método recibe
 * como parámetro un objeto de la clase Graphics que delimita la zona
 * que será pintada.
 * 
 * · update(Graphics g): ésta es la función que realmente se llama
 * cuando se necesita una actualización de la pantalla. La clase
 * Applet simplemente limpia el área y llama al método paint(Graphics g).
 * 
 * · repaint(): llamando a este método se podrá forzar la actualización
 * de un applet.
 */
/*
 * NUESTRO PRIMER APPLET
 * Recordemos que tenemos la clase Applet del paquete AWT
 * y JApplet del otro paquete Swing. Las diferencias son la mismas
 * que se expusieron en el Capítulo 8.
 * Para el primer ejemplo usaremos la clase de AWT; para el resto
 * JApplet de Swing, para ver que en cuanto a código no tiene
 * mayores diferencias
 */
// package prueba;
// comentado para evitar error en tiempo de ejecución clase y paquete no
// encontrado

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class PruebaApplet {
    /* Constructor por defecto no hace nada */
    public PruebaApplet() {

    }

    /* Inicializa el Applet no hace nada */
    public void init() {

    }
}
/*
 * Luego de compilar este PruebaApplet.java, con el comando:
 * 
 * #> javac PruebaApplet.java
 * 
 * se genera el archivo de bytecodes: PruebaApplet.class
 * 
 * Como siempre, vamos a crear el programa de prueba, pero esta vez
 * no es un método main(), sino un nuevo archivo HTML: PruebaApplet.html
 * con el siguiente contenido:
 * 
 * <HTML>
 * <APPLET CODE="PruebaApplet.class" WIDTH=300 HEIGHT=100>
 * </APPLET>
 * </HTML>
 * 
 * Como vemos en la Figura 2, a pesar de no tener código, el applet
 * muestra una pantalla gris de 300 por 100. (En mi computadora solo se ve
 * una página en blanco tanto en Microsoft Edge, como en Mozilla Firefox
 * como en Google Chrome). Este tamaño lo definimos con el código de HTML,
 * con las etiquetas WIDTH (Ancho) y HEIGHT (Alto).
 */
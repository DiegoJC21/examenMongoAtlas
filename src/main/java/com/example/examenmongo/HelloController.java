package com.example.examenmongo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnMostrar;

    @FXML
    private Label lblMensaje;

    @FXML
    private TextField txtArtista;

    @FXML
    private TextField txtAño;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    ConexionMongo cmn=new ConexionMongo();

    public void guardar(){
        Cancion c=new Cancion();
        c.setIdCancion(Integer.parseInt((txtId.getText())));
        c.setNombre((txtNombre.getText()));
        c.setArtista((txtArtista.getText()));
        c.setGenero((txtGenero.getText()));
        c.setAño((txtAño.getText()));

        if(cmn.insertar(c)==true){
            lblMensaje.setText("Los datos se guardaron con exito.");
            clean();
        } else{
            lblMensaje.setText("Hubo un error al guardar los datos");
        }
    }
    public void actualizar(){
        Cancion cancionAnterior = new Cancion();
        Cancion cancionNueva = new Cancion();
        if (txtId!=null) {
            cancionAnterior.setIdCancion(Integer.parseInt((txtId.getText())));
            cancionNueva.setIdCancion(Integer.parseInt((txtId.getText())));
            cancionNueva.setNombre((txtNombre.getText()));
            cancionNueva.setArtista((txtArtista.getText()));
            cancionNueva.setGenero((txtGenero.getText()));
            cancionNueva.setAño((txtAño.getText()));

            if(cmn.actualizar(cancionAnterior,cancionNueva)==true){
                lblMensaje.setText("Datos actualizados con éxito..");
                clean();
            } else{
                lblMensaje.setText("Datos no actualizados..");
            }
        } else{
            txtId.setText("Asigna un valor al id");
        }
    }
    public void show(){
        if(cmn.mostrar()==true){
            lblMensaje.setText("Los datos fueron mostrados en la consola");
            clean();
        } else{
            lblMensaje.setText("Hubo un error al mostrar los datos");
            clean();
        }
    }
    public void delete(){
        if(txtId!=null) {
            int id = Integer.parseInt(String.valueOf(txtId.getText()));
            if (cmn.eliminar(id) == true) {
                lblMensaje.setText("Registro eliminado..");
                clean();
            } else {
                lblMensaje.setText("Error al eliminar..");
            }
        } else{
            txtId.setText("Asigna un valor al id");
        }
    }

    public void clean() {
        txtId.setText("");
        txtNombre.setText("");
        txtArtista.setText("");
        txtAño.setText("");
        txtGenero.setText("");
    }

}
<template>
    <v-layout class="rounded rounded-md centered-layout">
      <div class="centered-message">
        
        <h1 class="titulo">Reportes</h1>
        <div class="tabla-container">
          <table class="tabla">
            <thead>
              <tr>
                <th>Usuario</th>
                <th>Cantidad de registros</th>
              </tr>
            </thead>
            <tbody>              
              <!-- donde se tomaría la cantida de reportes -->
              <tr  v-for="(entrada, index) in historial"  :key="index">
                <td style="text-align: center;">{{ entrada.email  }}</td>
                <td style="text-align: center;">{{ entrada.cantidadReportes }}</td>                                
              </tr>
            </tbody>
          </table>
        </div>
        <div class="input-container"></div>
      </div>
      <v-btn
        class="mb-8"
        color="purple"
        size="large"
        variant="tonal"
        to="/about"
      >
        Volver al menu de inicio 
      </v-btn>
    </v-layout>
  </template>
  
  <style scoped>
  .centered-layout {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }
  
  .centered-message {
    text-align: center;
    padding: 100px;
  }
  
  .titulo {
    font-size: 34px;
    font-weight: bold;
    
    padding: 15px;
    border: 2px solid #020202;
    border-radius: 10px;
    margin-bottom: 20px;
    margin-top: -200px;
    background-color: #EA7600;
  }
  
  .tabla-container {
    margin-top: 10px; /* Ajusta el margen superior */
    text-align: center;
  }
  
  .tabla {
    width: 100%; /* Usa el 100% del ancho */
    margin: 0 auto;
    border-collapse: collapse;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    table-layout: fixed; /* Ajusta el ancho de las columnas de manera uniforme */
  }
  
  
  .tabla th{
    
    border-top: 10px;
    border-bottom: 10px;
  }
  .tabla td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
    white-space: nowrap; 
    overflow: hidden;
    text-overflow: ellipsis; /* Agrega puntos suspensivos si el contenido es demasiado largo */
  }
  
  </style>
  
  <script> 
  import axios from 'axios';
  import Header from "../components/Header.vue";

  export default {
    components: {
      Header,
    },
    data() {
      return {
        historial: [],
        filtrado:''
      };
    },
    mounted() {
      this.cargarHistorial();
    },
    methods: {
      cargarHistorial() {
        const url = `http://localhost:8090/calcularLogs`;
        axios.get(url)
          .then(response => {
            this.historial = response.data;
          })
          .catch(error => {
            console.error('Error al cargar tareas:', error);
          });
      },
      mostrarBoton(tarea){
        return tarea.status;
      },
      esFiltrado(tarea){
        if(this.filtrado==''){
          return true;
        }
        if(tarea.status==null){
          return true;      }
        if(tarea.status == true && this.filtrado=="P"){
          return true;
        }else if(tarea.status==false && this.filtrado=="F"){
          return true;
        }else{
          return false;
        }
      },
      mostrarPend(){
        this.filtrado="P";
      },
      mostrarFin(){
        this.filtrado="F";
      }
  
    },
  };
  </script>
  
<template>
    <v-layout class="rounded rounded-md centered-layout">
      <Header />
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
              <tr  v-for="algo in historial"  :key="tarea.id_tarea">
                <td v-if="esFiltrado(tarea)">{{ tarea.titulo  }}</td>
                <td v-if="esFiltrado(tarea)">{{ tarea.descripcion }}</td>
                <td v-if="esFiltrado(tarea)">{{ mostrarStatus(tarea.status) }}</td>
                <td v-if="esFiltrado(tarea)">
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="input-container"></div>
      </div>
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
    padding: 20px;
  }
  
  .titulo {
    font-size: 34px;
    font-weight: bold;
    
    padding: 15px;
    border: 2px solid #020202;
    border-radius: 10px;
    margin-bottom: 20px;
    margin-top: 300px;
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
        const url = `http://localhost:8090/logs/calcularLogs`;
        axios.get(url)
          .then(response => {
            this.historial = response.data;
          })
          .catch(error => {
            console.error('Error al cargar tareas:', error);
          });
      },
      mostrarBoton(tarea){
        console.log(tarea.status)
        console.log(tarea)
        return tarea.status;
      },
      esFiltrado(tarea){
        if(this.filtrado==''){
          return true;
        }
        console.log(tarea);
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
  
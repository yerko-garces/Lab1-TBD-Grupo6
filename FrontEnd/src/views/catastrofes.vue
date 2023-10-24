 
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
    background-color: #EA7600;
  }
  
  .tabla-container {
    margin-top: 20px;
  }
  
  .tabla {
    width: 100%;
    margin: 0 auto;
    border-collapse: collapse;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  }
  
  .tabla th,
  .tabla td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  
  .tabla th {
    background-color: #EA7600;
    color: white;
  }
  </style>
    
    
    
  <script>
  import axios from 'axios';
  import Header from "../components/Header.vue";
import { VLayoutItem } from 'vuetify/lib/components/index.mjs';
  export default {
    components: {
      Header,
    },
    data() {
      return {
        historial: [],
        voluntario: "",
  
      };
    },
    mounted() {
      this.getVol();
      this.cargarCatastrofes();
    },
    methods: {
      async cargarCatastrofes() {
        console.log(this.voluntario.idVoluntario);
        const url = `http://localhost:8090/emergencia/verEmergenciasDisponibles/`+this.voluntario.idVoluntario;
        await axios.get(url)
          .then(response => {
            console.log(JSON.stringify(response.data));
            this.historial = response.data;
          })
          .catch(error => {
            console.error('Error al cargar emergencia:', error);
          });
      },
      verPrerequisitos(idEmergencia){
        localStorage.setItem("idEmergencia", JSON.stringify(idEmergencia));
        this.$router.push("/mostrarPrerequisitos");
    },getVol(){
        this.voluntario = JSON.parse(localStorage.getItem("voluntario"));
    },
    }
  };
  </script>

<template>
    <v-layout class="rounded rounded-md centered-layout">
      <Header />
      <div class="centered-message">
        <h1>
          <img alt="Vue logo" class="logo" src="@/assets/logo_sai_usach_4.png" width="100" height="100" />
        </h1>
        <p class="titulo">Emergencia</p>
        <div class="tabla-container">
          <table class="tabla">
            <thead>
            <tr>
              <th>Nombre de Emergencia</th>
            </tr>
          </thead>
            <tbody>
              <tr v-for="emergencia in historial" :key="emergencia.idEmergencia">
                <td>{{ emergencia.nombreEmergencia }}</td>
                <td>
                <v-btn block class="mb-1" color="blue" background-color="#394049" @click="verPrerequisitos(emergencia.idEmergencia)">
                  <div>Ver requisitos</div>
                </v-btn>
                <v-btn block class="mb-1" color="green" background-color="#394049" @click="verPrerequisitos(emergencia.idEmergencia)">
                  <div>Aceptar tarea</div>
                </v-btn>
                <router-link to="/about">
                <v-btn
                  class="mb-8"
                  color="blue"
                  size="large"
                  variant="tonal"
                >
                  VOLVER AL INICIO
                </v-btn>
              </router-link>
              </td>
              </tr> 
            </tbody>
          </table>
        </div>
        <div class="input-container">
        </div>
      </div>
    </v-layout>
  </template>
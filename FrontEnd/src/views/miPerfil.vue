<template>
  <v-layout class="rounded rounded-md">
    <Header />
    <v-main>
      <div class="centered-layout">
        <div class="centered-message">
          <h2 class="sub-titulo">Datos de usuario</h2>
          <div class="content">
              <v-card
                class="mx-auto pa-12 pb-8"
                elevation="4"
                max-width="500"
                rounded="lg"
                style="margin-top: 20px"
              >
                <div class="text-subtitle-1 text-medium-emphasis" >Email</div>
                <v-responsive class="mx-auto" max-width="400">
                    <v-text-field  v-model="voluntario.emailVoluntario" type="email"></v-text-field>
                </v-responsive>
                <div class="text-subtitle-1 text-medium-emphasis" >Nombre</div>
                <v-responsive class="mx-auto" max-width="400">
                    <v-text-field v-model="voluntario.nombreCompletoVoluntario" type="input"></v-text-field>
                </v-responsive>
                <div class="text-subtitle-1 text-medium-emphasis" >Rut</div>
                <v-responsive class="mx-auto" max-width="400">
                    <v-text-field v-model="voluntario.rutVoluntario" type="input" ></v-text-field>
                </v-responsive>
                <v-btn
                  class="mb-8"
                  color="green"
                  size="large"
                  variant="tonal"
                  max-width="500"
                  @click="actualizar"
                >
                  ACTUALIZAR
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
              </v-card>  
          </div>
        </div>
      </div>
    </v-main>
  </v-layout>
</template>

<script>

import axios from 'axios';
import Header from "../components/Header.vue";

export default {
  components: {
    Header,
  },
  data() {
    return {
      voluntario:"",
    };
  },
  mounted(){
    this.getVol();
  },
  computed:{
    valido(){
      return /.+@.+\..+/.test(this.voluntario.emailVoluntario);
    }
  },
  methods: {
    getVol(){
        this.voluntario = JSON.parse(localStorage.getItem("voluntario"));
    },
    async actualizar() {
      try {
        if(!this.valido){
          this.$swal({ 
              icon: 'error',
              title: 'Campos no validos',
              text: 'Complete los datos'}).then(() => {
          });
        }else{
         const res = await axios.put(
            "http://localhost:8090/voluntario/actualizarUser/"+this.voluntario.idVoluntario,
            this.voluntario
        ); 
        localStorage.removeItem('voluntario');
        localStorage.setItem('voluntario',JSON.stringify(this.voluntario))
        this.lista1=this.seleccion;
        this.$swal({ 
              icon: 'success',
              title: 'Éxito',
              text: 'Se actualizaron los Datos de Usuario correctamente'}).then(() => {
              this.$router.push("/miPerfil");
              this.getVol();
          });
        }
      } catch (error) {
        console.error(error);
      }
    },
    }
};
</script>

<style scoped>
.info-details {
    border: 2px solid #a5a4a4;
    border-radius: 10px;
    padding: 15px;
    text-align: left;
    margin: 20px;
}
.sub-titulo {
    border: 2px solid #a5a4a4;
    border-radius: 10px;
    padding: 15px;
    text-align: center;
    margin: 20px;
}
</style>

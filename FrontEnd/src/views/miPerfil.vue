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
                    <v-text-field  value="gabriel.ojeda@usach.cl" type="input"></v-text-field>
                </v-responsive>
                <div class="text-subtitle-1 text-medium-emphasis" >Nombre</div>
                <v-responsive class="mx-auto" max-width="400">
                    <v-text-field value="Gaeloco" type="input"></v-text-field>
                </v-responsive>
                <div class="text-subtitle-1 text-medium-emphasis" >Rut</div>
                <v-responsive class="mx-auto" max-width="400">
                    <v-text-field value="20.117.689-1" type="input" ></v-text-field>
                </v-responsive>
                <v-btn
                  class="mb-8"
                  color="green"
                  size="large"
                  variant="tonal"
                  max-width="500"
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
      seleccion: [],
      items: [],
      lista1: [],
      voluntario:"",
    };
  },
  mounted(){
    this.getHabilidades(); //cambiar por obtener las no seleccionadas
    this.getVol();
    this.getObtenidas(); //obtener habilidades ya escogidas
  },
  methods: {
    async getObtenidas(){
      try{
        const res = await axios.get(
          "http://localhost:8090/voluntarioHabilidad/getHabilidadesVoluntario/" + this.voluntario.idVoluntario
        );
        this.seleccion = res.data;
        this.lista1 = res.data;
      }catch{
        console.log("catch de obtenidas")
      }
    },

    async getHabilidades(){
        try{
            const res = await axios.get(
                "http://localhost:8090/habilidad/get"
            );
            this.items = res.data;
        }catch{
            console.log("catch")
        }
    },
    async actualizar() {
      try {
        const res = await axios.post(
            "http://localhost:8090/voluntarioHabilidad/actualizarHabilidadesVoluntario/"+this.voluntario.idVoluntario,
            [this.lista1, this.seleccion]
        );
        this.lista1=this.seleccion;
        console.log(res.data);
        this.$router.push("/habilities");
      } catch (error) {
        console.error(error);
      }
    },


    itemProps (item) {
        return {
          title: item.nombreHabilidad,
          subtitle: item.id_habilidad,
        }
    },
    getVol(){
        this.voluntario = JSON.parse(localStorage.getItem("voluntario"));
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

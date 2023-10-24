<template>
  <v-layout class="rounded rounded-md">
    <Header />
    <v-main>
      <div class="centered-layout">
        <div class="centered-message">
          <div class="content">
            <h2 class="sub-titulo">Mis Habilidades</h2>
            <v-card
                class="mx-auto pa-12 pb-8"
                elevation="4"
                max-width="600"
                rounded="lg"
                style="margin-bottom: 50px"
              >
              <v-list :items="habilidadesUser" :item-props="itemProps"
              ></v-list>
            </v-card>
            <h2 class="sub-titulo">Actualizar Habilidades</h2>
            <div class="sub-titulo">
                <v-select clearable multiple v-model="seleccion" :items="habilidades" :item-props="itemProps" ></v-select>
              <v-btn class="mb-8"
                  color="green"
                  size="large"
                  variant="tonal"
                  max-width="500" @click="actualizar">Actualizar</v-btn>
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
            </div>
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
  data: () => ({
      items: [],
      habilidadesUser: [],
      habilidades: [],
      seleccion: [],
      lista1:[]
    }),
  mounted(){
    this.getHabilidades(); //cambiar por obtener las no seleccionadas
    this.getVol();
    this.getObtenidas(); //obtener habilidades ya escogidas
  },
  methods: {
    async getObtenidas(){
      try{
        const res = await axios.get(
          "http://localhost:8090/voluntarioHabilidad/getAllHabilidadesVoluntario/" + this.voluntario.idVoluntario
        );
        this.seleccion = res.data;
        this.lista1 = res.data;
        this.habilidadesUser = res.data;
      }catch{
      }
    },

    async getHabilidades(){
        try{
          const url = "http://localhost:8090/habilidad/get";
          axios.get(url)
          .then(response => {
            this.habilidades = response.data;
          })
            const res = await axios.get();
            this.items = res.data;
        }catch{
          console.log("error al obtener todas las habilidades")
        }
    },
    async actualizar() {
      try {
        const res = await axios.post(
            "http://localhost:8090/voluntarioHabilidad/actualizarHabilidadesVoluntario/"+this.voluntario.idVoluntario,
            [this.lista1, this.seleccion]
        );
        this.lista1=this.seleccion;
        this.$swal({ 
              icon: 'success',
              title: 'Éxito',
              text: 'Se actualizaron las Habilidades correctamente'}).then(() => {
              this.$router.push("/habilities");
              this.getHabilidades();
              this.getVol();
              this.getObtenidas();
          });
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

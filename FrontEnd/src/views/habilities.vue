<template>
  <v-layout class="rounded rounded-md">
    <Header />
    <v-main>
      <div class="centered-layout">
        <div class="centered-message">
          <h1 class="titulo">Datos de usuario</h1>
          <div class="content">
            <form>
                <v-select chips multiple v-model="seleccion" label="Habilidades" :items="items" :item-props="itemProps" ></v-select>
              <v-select chips multiple v-model="lista2" label="Habilidades" :items="lista1" :item-props="itemProps" ></v-select>

              <v-btn class="button" @click="actualizar" color="black" variant="outlined">Enviar</v-btn>
            </form>
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
      seleccion: [], //los seleccionados que el usuario eligio para añadir
      items: [],  // son todas las habilidades disponibles para elegir
      lista1: [], // son las habilidades que el usuario ya tiene
      lista2: [], // habilidades que el usuario va a quitarse
      voluntario:"",
    };
  },
  mounted(){
    this.getHabilidades(); //cambiar por obtener las no seleccionadas
    this.getVol();
    this.getSeleccionados(); //obtener habilidades ya escogidas
  },
  methods: {
    async getSeleccionados(){
      try{
        const res = await axios.get(
          "http://localhost:8090/voluntarioHabilidad/getHabilidadesVoluntario/" + this.voluntario.idVoluntario
        );
        this.lista1 = res.data;
        console.log(this.seleccion)
        console.log(this.items)
      }catch{
        console.log("catch")
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
    actualizar(){
      const idVoluntario = this.voluntario.idVoluntario;
      this.seleccion.forEach(async element => {
        try{
          const res = await axios.post(
            "http://localhost:8090/voluntarioHabilidad/crearVoluntarioHabilidad",
            {
              idVoluntario: idVoluntario,
              idHabilidad: element.id_habilidad,
            }
          );
        }catch{
          console.log("catch")
        }
      });
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
/* Mantén tus estilos existentes */
</style>

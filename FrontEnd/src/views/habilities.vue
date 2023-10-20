<template>
  <v-layout class="rounded rounded-md">
    <Header />
    <v-main>
      <div class="centered-layout">
        <div class="centered-message">
          <h1 class="titulo">Datos de usuario</h1>
          <div class="content">
            <form>
              <v-text-field v-model="useridHabilidad" label="Nombre del Usuario" required></v-text-field>
                <v-select chips multiple label="Habilidades" :items="items" :item-props="itemProps"></v-select>
                <v-btn class="button" color="black" variant="outlined">Enviar</v-btn>
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
      useridHabilidad: '',
      selectedFrutas: [],
      items: [],
    };
  },
  mounted(){
    this.getHabilidades();
    this.getVol();
  },
  methods: {
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
    submitForm() {
      console.log('Nombre del Usuario:', this.useridHabilidad);
      console.log('Frutas seleccionadas:', this.selectedFrutas);
    },
    itemProps (item) {
        return {
          title: item.nombreHabilidad,
          subtitle: item.id_habilidad,
        }
    },
    getVol(){
        this.voluntario = localStorage.getItem("voluntario");
        console.log(this.voluntario);
    },
    }
};
</script>

<style scoped>
/* Mantén tus estilos existentes */
</style>

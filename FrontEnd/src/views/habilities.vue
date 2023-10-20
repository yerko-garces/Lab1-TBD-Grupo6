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

              <v-btn class="button" @click="actualizar" color="black" variant="outlined">Enviar</v-btn>
            </form>
          </div>
        </div>
      </div>
    </v-main>
  </v-layout>
</template>

<script>
// EN LA PRIMERA SE DEBERIA OBTENER UNA LISTA DE HABILIDADES QUE NO ESTEN EN LA LISTA DE HABILIDADES DEL VOLUNTARIO
// LUEGO CON LE BOTON SE DEBERIA APLICAR CREAR UNA TUPLA DE VOL-HAB

//EN LA SEGUNDA SE DEBERIA OBTENER UNA LISTA DE HABILIDADES QUE SI ESTEN EN LA LISTA DE HABILIDADES DEL VOLUNTARIO
// LUEGO CON LE BOTON SE DEBERIA APLICAR ELIMINAR UNA TUPLA DE VOL-HAB

//PERO ANTES INTENTAR OBTENER LA LISTA DE HABILIDADES QUE YA TIENE EL VOLUNTARIO SEGUN VOL-HAB

//ya es muetran los obtenido, ahora hay que saber cuales se eliminan y cuales se crean

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
/* Mantén tus estilos existentes */
</style>

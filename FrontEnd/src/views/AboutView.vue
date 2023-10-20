<template>
  <v-layout class="rounded rounded-md">
    <Header />
    <v-main>
      <div class="centered-layout">
        <div class="centered-message">
          <h1 class="titulo">Este es un servicio que permite gestionar de manera eficiente y efectiva las distintas catástrofes</h1>
          <div class="content">
            <img
              alt="Vue logo"
              class="logo"
              src="@/assets/logo_sai_usach_4.png"
              width="300"
              height="300"
            />
            <br>
            <form>
              <v-text-field v-model="userName" label="Nombre del Usuario" required></v-text-field>
              <v-select
                v-model="selectedFrutas"
                :items="frutas"
                label="Selecciona Frutas"
                multiple
                chips
                item-text="nombre"
                item-value="id"
              ></v-select>
              <v-btn class="button" color="black" variant="outlined" @click.prevent="submitForm">Enviar</v-btn>
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
      userName: '',
      selectedFrutas: [],
      frutas: [
        { id: 1, nombre: 'Manzana' },
        { id: 2, nombre: 'Banana' },
        { id: 3, nombre: 'Fresa' },
        // Agrega más frutas según sea necesario
      ],
    };
  },
  methods: {
    submitForm() {
      // Puedes manejar la lógica del formulario aquí
      console.log('Nombre del Usuario:', this.userName);
      console.log('Frutas seleccionadas:', this.selectedFrutas);
    },
  },
};
</script>

<style scoped>
/* Mantén tus estilos existentes */
</style>

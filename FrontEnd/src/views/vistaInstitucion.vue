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
          <ul>
          </ul>
          <br>
          <v-btn class="button" color="black" variant="outlined" to="/.">Botón 1</v-btn>
          <v-btn class="button" color="black" variant="outlined" to="/.">Botón 2</v-btn>
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
  }
}
</script>

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
  padding: 10px;
}

.titulo {
  font-size: 24px;
  font-weight: black;
  padding: 15px;
  border: 2px solid #020202;
  border-radius: 10px;
  background-color: #EA7600;
}

.descripcion {
  font-size: 18px;
  color: #030303;
}

.button {
  font-size: 19px;
  margin-top: 20px;
  margin-right: 20px;
}
</style>
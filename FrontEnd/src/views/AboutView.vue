<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar title="BIENVENIDO AL SISTEMA DE CATASTROFE"></v-app-bar>
    <v-navigation-drawer app>
    <v-list>
      <v-list-item to="/..." class="borde">
        <div class="center-text">Catastrofe</div>
      </v-list-item>
      <v-list-item to="/..." class="borde">
        <div class="center-text">Historial</div>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
<v-main>
  <div class="centered-layout">
    <Header />
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
        <!--<p class="titulo">Este es un servicio que permite gestionar de manera eficiente y efectiva las distintas catástrofes</p>-->
        <br>
        <ul>
          <!-- <p class="descripcion">Este es un servicio que permite gestionar de manera eficiente y efectiva las distintas catástrofes.</p>-->
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
.borde {
  border: 1px solid #999999;
  border-radius: 50px;
  padding: 0px;
  margin: 10px 10px;
  font-weight: bold;
}
.center-text {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
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
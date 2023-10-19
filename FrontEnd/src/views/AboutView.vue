<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar title="BIENVENIDO AL SISTEMA DE CATASTROFE"></v-app-bar>
    <v-navigation-drawer>
      <v-list>
        <v-list-item title="Navigation drawer"></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <!-- Contenido de la página -->
    <v-main>
      <!-- Contenido personalizado -->
      <div class="centered-layout">
        <Header />
        <div class="centered-message">
          <h1>
            <img
                alt="Vue logo"
                class="logo"
                src="@/assets/logo_sai_usach_4.png"
                width="300"
                height="300"/>
          </h1>
          <p class="titulo">Este es un servicio que permite gestionar de manera eficiente y efectiva las distintas catástrofes</p>
          <br>
          <ul>
            <li>
              <!-- <p class="descripcion">Este es un servicio que permite gestionar de manera eficiente y efectiva las distintas catástrofes.</p>-->
            </li>
          </ul>
          <br>
          <v-btn class="button" color="black" variant="outlined" to="/.">.....</v-btn>
          <v-btn class="button" color="black" variant="outlined" to="/.">...</v-btn>
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
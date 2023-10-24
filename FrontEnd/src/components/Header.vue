<template>
    <v-app-bar>
      <v-toolbar>
          <img
            alt="Vue logo"
            class="logo"
            src="@/assets/logo_sai_usach_4.png"
            width="70"
            margin-left="5"
            height="70"
            style="margin-left: 5px;"
          />
          <div class="text-subtitle-1 text-medium-emphasis">Grupo 6</div>
        <v-spacer></v-spacer>
        <v-btn variant="plain" to="/">
          Cerrar Sesión
          <v-icon class="icon"
            ><img
              alt="Cerrar sesión"
              src="@/assets/cerrar-sesion.png"
              width="25"
              height="16"
              style="margin-left: 8px;"
          /></v-icon>
        </v-btn>
      </v-toolbar>
    </v-app-bar>
    <v-navigation-drawer app>
    <v-list>
      <v-list-item to="/miPerfil" class="borde">
        <div class="center-text">Mi Perfil</div>
      </v-list-item>
      <v-list-item to="/habilities" class="borde">
        <div class="center-text">Mis Habilidades</div>
      </v-list-item>
      <v-list-item to="/catastrofes" class="borde">
        <div class="center-text">Catástrofes</div>
      </v-list-item>

    </v-list>
    </v-navigation-drawer>
  </template>
<script>
  export default {
    name: "Header",
  };
</script>
  
<style scoped>
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
</style>
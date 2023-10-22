<template>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="15"
      max-width="700"
      rounded="lg"
      style="margin-top: 40px"
    >
      <h1 style="text-align: center;">GESTIÓN DE CATÁSTROFES</h1>
      <h3 style="text-align: center;">
        Bienvenido al sistema de gestión de catástrofes y voluntariado
      </h3> 
      <p style="text-align: center;">
        Este sistema está diseñado para coordinar y optimizar la respuesta a eventos catastróficos, como terremotos, inundaciones, incendios forestales y otros desastres naturales o provocados por el ser humano. Este sistema integra tecnología, datos, recursos y procesos para facilitar la toma de decisiones y la respuesta eficiente ante emergencias.
      </p> 
    </v-card>
  </div>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="15"
      max-width="700"
      rounded="lg"
      style="margin-top: 40px"
    >
      <p>
        Para continuar debe elegir el perfil con el cual desea entrar al sistema:
      </p>
      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        to="/login"
        style="margin-top: 40px"
      >
        Voluntario
      </v-btn>

      <v-btn
        block
        class="mb-8"
        color="blue"
        size="large"
        variant="tonal"
        to="/loginInstitucion"
      >
        Institución
      </v-btn>

      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "preLogin",
};
</script>

<style scoped>
body {
  background-color: #424953;
  display: flex;
  justify-content: center;
  align-items: center;
}

.log-in {
  color: #00a499;
}

body {
  height: 100vh;
}

#flexbox {
  display: flex;
}

#divImagen {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>

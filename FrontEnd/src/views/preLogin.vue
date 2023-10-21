<script>
export default {
  name: "preLogin",
};
</script>
<template>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="15"
      max-width="500"
      rounded="lg"
      style="margin-top: 40px"
    >

      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        to="/login"
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

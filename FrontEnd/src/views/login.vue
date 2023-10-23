<script>
import axios from "axios";

export default {
  name: "login",
  data() {
    return {
      usuario: "",
      password: "",
      error: "",
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios({
          method: "POST",
          url: "http://localhost:8090/voluntario/login",
          data: {
            emailVoluntario: this.usuario,
            contraseniaVoluntario: this.password,
          },
        });

        if (response.status === 200) {
          
          const token = response.data.token;
          const voluntario = response.data.voluntario
          localStorage.setItem("token", token);
          axios.defaults.headers.common["Authorization"] =`Bearer ${token}`;
          localStorage.setItem('voluntario',JSON.stringify(voluntario))

          this.$router.push("/about");
        }
      } catch (error) {
        this.$swal({
          icon: "error",
          title: "Error",
          text: "Credenciales inválidas.",
        });
      }
    },
  },
};
</script>
<template>
  <h3 style="text-align: center; margin-top: 40px;">
        VOLUNTARIO
      </h3>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="10"
      max-width="500"
      rounded="lg"
      style="margin-top: 40px"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Cuenta Voluntario</div>
      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Usuario"
          placeholder="Introduzca su email de usuario"
          type="email"
          v-model="usuario"
        ></v-text-field>
      </v-responsive>

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Contraseña"
          placeholder="Introduzca su contraseña"
          type="password"
          v-model="password"
        ></v-text-field>
      </v-responsive>

      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        @click="login"
      >
        INICIAR SESIÓN
      </v-btn>

      <v-btn
        block
        class="mb-8"
        color="blue"
        size="large"
        variant="tonal"
        to="/register"
        @click="crear"
      >
        Registrarse
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

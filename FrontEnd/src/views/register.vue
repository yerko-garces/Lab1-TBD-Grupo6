<script>
import axios from "axios";

export default {
  name: "register",
  data() {
    return {
      emailVoluntario:"",
      rut:"",
      nombre:"",
      password: "",
      error: "",
    };
  },
  computed:{
    valido(){
      return /.+@.+\..+/.test(this.emailVoluntario);
    }
  },
  methods: {
    async registrar() {
      try {
        if(!/.+@.+\..+/.test(this.emailVoluntario)){
          this.$swal({ 
              icon: 'error',
              title: 'Correo no valido',
              text: 'Ingrese un correo valido',
          })
        }else{
          const response = await axios({
          method: "POST",
          url: "http://localhost:8090/voluntario/register",
          data: {
            emailVoluntario: this.emailVoluntario,
            contraseniaVoluntario: this.password,
            nombreCompletoVoluntario: this.nombre,
            rutVoluntario: this.rut
          },
        });
        if (response.status === 200) {
          this.$swal({ 
              icon: 'success',
              title: 'Éxito',
              text: 'Su perfil de Voluntario se creó exitosamente',
          }).then(() => {
              this.$router.push('/login'); // Redirige al usuario
          });
        } 
        
        }        
      } catch (error) {
        this.$swal({
          icon: "error",
          title: "Error",
          text: "Error al registrarse",
        });
      }
    },
  },
};
</script>
<template>
  <h3 style="text-align: center; margin-top: 40px;">
        CREAR CUENTA VOLUNTARIO
      </h3>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="15"
      max-width="500"
      rounded="lg"
      style="margin-top: 40px"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Ingrese los datos:</div>
      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Correo"
          placeholder="Introduzca su email de usuario"
          type="email"
          v-model="emailVoluntario"
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

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Nombre"
          placeholder="Introduzca su nombre"
          type="input"
          v-model="nombre"
        ></v-text-field>
      </v-responsive>

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Rut"
          placeholder="Introduzca su Rut"
          type="input"
          v-model="rut"
        ></v-text-field>
      </v-responsive>

      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        @click="registrar"
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

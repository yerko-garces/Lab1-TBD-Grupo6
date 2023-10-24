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
  data: () => ({
      items: [],
      voluntario: null,
    }),
  mounted(){
    this.getVol();
    this.getObtenidas(); //obtener habilidades ya escogidas
  },
  methods: {
    getVol(){
        this.voluntario = JSON.parse(localStorage.getItem("voluntario"));
    },
    async getObtenidas(){
      try{
        console.log("pre funcion")
        const res = await axios.get(
          "http://localhost:8090/voluntarioHabilidad/getHabilidadesVoluntario/" + this.voluntario.idVoluntario);
        this.compareUser(res.data);
      }catch{
        console.log("catch de obtenidas")
      }
    },
    compareUser(lista){
      if (lista.length === 0){
        console.log(lista.length)
        this.$swal({
              icon: 'info',
              title: 'ACTUALICE SU PERFIL',
              text: 'Recuerde registrar las habilidades acorde a su perfil',
          }).then(() => {
              this.$router.push('/habilities');
          });
      } 
    },
}}
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
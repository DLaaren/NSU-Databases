<template>
  <v-app> <!--синоним для <div id="app">-->

    <v-main> <!--контент самого приложения-->

      <v-app-bar
        app
      >
        <v-app-bar-nav-icon>
        </v-app-bar-nav-icon>

        <v-app-bar-title>
          <h3>Zookeeper</h3>
        </v-app-bar-title>

      </v-app-bar>

      <MainPage/>
      <AnimalsDataTable/>
    </v-main>


  </v-app>
</template>

<script setup>
</script>

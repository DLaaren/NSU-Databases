<template>
    <v-container>
        <v-responsive
        class="align-centerfill-height mx-auto"
        max-width="1500"
        >
            <v-data-table v-if="state === 'loaded'"
            v-model:items-per-page="itemsPerPage"
            :headers="headers"
            :items="animals" item-value="id"
            class="elevation-1">
            </v-data-table>
            
        </v-responsive>
    </v-container>
</template>

<script>
export default {
    data: () => ({
        state: 'loading',
        itemsPerPage: 10,
        headers: [
            { title: 'Animal ID', align: 'center', key: 'id' },
            { title: 'Name', align: 'center', key: 'name' },
            { title: 'Species Name', align: 'center', key: 'speciesName' },
            { title: 'Need warm cage?', align: 'center', key: 'needWarmCage' },
        ],
    }),
    methods: {
      async getData() {
        try {
          const response = await fetch(
            'http://localhost:8080/api/v1/animal/all', { method: 'GET' });
          this.animals = await response.json();
          this.state = 'loaded'
        } catch (error) {
          console.error(error);
          this.state = 'error'
        }
      },
    },
    created() {
      this.getData()
    },
}
</script>
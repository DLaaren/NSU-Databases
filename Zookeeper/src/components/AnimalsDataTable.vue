<template>
    <v-container>
        <v-responsive
        class="align-centerfill-height mx-auto"
        max-width="1500"
        >
            <h2 class="text-left text-h3 font-weight-bold">Animals</h2>
            <br>

            <v-data-table
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
    name: 'DataTable',
    data: () => ({
        itemsPerPage: 10,
        headers: [
            {
                title: 'Animal ID',
                align: 'center',
                sortable: false,
                key: 'id'
            },
            { title: 'Name', align: 'center', key: 'name' },
            { title: 'Species ID', align: 'center', key: 'speciesId' },
            { title: 'Vet card ID', align: 'center', key: 'vetCardId' },
            { title: 'Need warm cage?', align: 'center', key: 'needWarmCage' },
        ],  
        animals: [{
          "id": 1,
          "name": "Jack",
          "speciesId": 1,
          "vetCardId": 1,
          "needWarmCage": true
        }]
    }),
    methods: {
      async getData() {
        const response = await fetch(
          `https://localhost:8080/api/v1/animal/all`,
          {
            method: 'GET'
          }
        );
        this.animals = await response.json();
        print(response);
      },
    },
    created() {
      this.getData()
    },
}
</script>
<template>
    <v-container>
        <v-responsive
        class="align-centerfill-height mx-auto"
        max-width="1500"
        >
            <h2 class="text-left text-h3 font-weight-bold">Species</h2>
            <br>

            <v-data-table
            v-model:items-per-page="itemsPerPage"
            :headers="headers"
            :items="species" item-value="id"
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
                title: 'Species ID',
                align: 'center',
                sortable: false,
                key: 'id'
            },
            { title: 'Name', align: 'center', key: 'name' },
            { title: 'Feeding Type', align: 'center', key: 'feedingType' },
        ],  
        species: [{
          "id": 1,
          "name": "Rabbit",
          "feedingType": "HERBIVORE"
        },]
    }),
    methods: {
      async getData() {
        const response = await fetch(
          `https://localhost:8080/api/v1/species/all`,
          {
            method: 'GET'
          }
        );
        this.speices = await response.json();
        print(response);
      },
    },
    created() {
      this.getData()
    },
}
</script>
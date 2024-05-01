<template>
    <v-container>
        <v-responsive
        class="align-centerfill-height mx-auto"
        max-width="1000"
        >
            <v-card>
                <h1>Enter an animal id</h1>
                <v-toolbar dense floating v-on:keyup.enter="getData">
                    <v-text-field
                        v-model="search"
                        label="Search"
                        prepend-inner-icon="mdi-magnify"
                        variant="outlined"
                        hide-details
                        single-line
                        v-on:keyup.enter="getData"
                    >
                    </v-text-field>
                </v-toolbar>

                <v-responsive v-if="state === 'loaded'">
                    <br>
                    <h1>Animal</h1>
                    <br>
                    <h3>Name:</h3>
                    <v-text-field v-model="animal.name"></v-text-field>
                    <h3>Species: </h3>
                    <v-text-field v-model="animal.speciesName"></v-text-field>
                    <h3>Cage No.: </h3>
                    <v-text-field v-model="animal.cageId"></v-text-field>
                    <h3>Need Warm Cage? </h3>
                    <v-text-field v-model="animal.needWarmCage"></v-text-field>
                </v-responsive>

                <v-expand-transition>
                <v-responsive v-if="state === 'loaded' && expand === true">
                    <br>
                    <h1>Vet Card</h1>
                    <br>
                    <v-card>
                        <h3>Age:</h3>
                        <v-text-field v-model="vetCard.age"></v-text-field>
                        <h3>Sex:</h3>
                        <v-text-field v-model="vetCard.sex"></v-text-field>
                        <h3>Height:</h3>
                        <v-text-field v-model="vetCard.height"></v-text-field>
                        <h3>Weight: </h3>
                        <v-text-field v-model="vetCard.weight"></v-text-field>
                        <h3>Need Isolation? </h3>
                        <v-text-field v-model="vetCard.needIsolation"></v-text-field>
                        <h3>Pregnant?</h3>
                        <v-text-field v-model="vetCard.isPregnant"></v-text-field>
                        <div v-if="vetCard.gestationTerm !== null && vetCard.isPregnant === true">
                        <h3>GestationTerm:</h3>
                        <v-text-field v-model="vetCard.gestationTerm"></v-text-field>
                        </div>
                        <div v-if="vetCard.addInfo !== null">
                        <h3>Add info: </h3>
                        <v-text-field v-model="vetCard.addInfo"></v-text-field>
                        </div>
                    </v-card>
                </v-responsive>
                </v-expand-transition>

                    <v-card-actions>
                        <v-btn
                            :text="!expand ? 'Full Report' : 'Hide Report'"
                            @click="expand = !expand"
                        ></v-btn>
                        <v-btn @click="updateData">Update</v-btn>
                        <v-btn @click="deleteData">Delete</v-btn>
                    </v-card-actions>

                <h1 v-if="state === 'not found'"> Not Found </h1>

            </v-card>
        </v-responsive>
    </v-container>

</template>

<script>
export default {
    data: () => ({
        search: null,
        state: 'loading',
        expand: false,
        animal: {
            id: null, name: null, speciesName: null, vetCard: null, cageId: null, needWarmCage: null
        },
        vetCard: {
            id: null, age: null, sex: null, height: null, weight: null, needIsolation: null, isPregnant: null, gestationTerm: null, addInfo: null
        },
    }),
    methods: {
        async getData() {
            this.state = 'loading'
            try {
                const response = await fetch(
                    'http://localhost:8080/api/v1/animal/' + this.search, { method: 'GET' });
                if (response.status == 404) {
                    this.state = 'not found'
                    return
                }

                this.animal = await response.json()
                this.vetCard =  JSON.parse(JSON.stringify(this.animal.vetCard))
                this.animal = JSON.parse(JSON.stringify(this.animal))

                console.log(this.vetCard)
                
                this.animal.needWarmCage = this.animal.needWarmCage?"yes":"no"

                this.vetCard.needIsolation = this.vetCard.needIsolation?"yes":"no"
                this.vetCard.isPregnant = this.vetCard.isPregnant?"yes":"no"
                this.vetCard.gestationTerm = new Date(this.vetCard.gestationTerm).toLocaleDateString()

                this.state = 'loaded'
            } catch (error) {
                console.error(error);
                this.state = 'error'
            }
        },
        async updateData() {
            this.state = 'loading'
            try {
        
                switch (this.animal.needWarmCage) {
                    case "yes":
                        this.animal.needWarmCage = true
                        break;
                
                    case "no":
                        this.animal.needWarmCage = false
                        break;
                    default:
                        return;
                }

                switch (this.vetCard.needIsolation) {
                    case "yes":
                        this.vetCard.needIsolation = true
                        break;
                
                    case "no":
                        this.vetCard.needIsolation = false
                        break;
                    default:
                        return;
                }

                switch (this.vetCard.isPregnant) {
                    case "yes":
                        this.vetCard.isPregnant = true
                        break;
                
                    case "no":
                        this.vetCard.isPregnant = false
                        break;
                    default:
                        return;
                }

                this.vetCard.gestationTerm = new Date(this.vetCard.gestationTerm).getTime()
                
                const response = await fetch(
                'http://localhost:8080/api/v1/animal/' + this.animal.id, { method: 'PUT', headers: { "Content-Type": "application/json" }, body: JSON.stringify(this.animal) });

                this.state = 'loaded'
            } catch (error) {
                console.error(error);
                this.state = 'error'
            }
        },
        async deleteData() {
            this.state = 'loading'
            try {
            const response = await fetch(
                'http://localhost:8080/api/v1/animal/' + this.animal.id, { method: 'DELETE', headers: { "Content-Type": "application/json" }, body: JSON.stringify(this.animal.id) });
                this.animal = null
            } catch (error) {
                console.error(error);
                this.state = 'error'
            }
        },
    },
}
</script>
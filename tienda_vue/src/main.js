import { createApp } from 'vue';
import App from './App.vue';
import mongoose from 'mongoose';
import MovieList from './components/MovieList.vue';
import Movie from './models/movies.js';

mongoose.connect('mongodb://localhost:27017/prueba', {useNewUrlParser: true, useUnifiedTopology: true}).then(() => {
    console.log('Connected to MongoDB');
    // Fetch data from MongoDB
    Movie.find({}, (err, movies) => {
        if (err) {
            console.error('Error fetching movies:', err);
        } else {
            // Pass the movies to the MovieList component
            const app = createApp({
                render: (h) => h(App),
                components: {
                    MovieList
                },
                data() {
                    return {
                        movies: movies
                    };
                }
            });
            app.mount('#app');
        }
    });
}).catch((error) => {
    console.error('Error connecting to MongoDB:', error);
});
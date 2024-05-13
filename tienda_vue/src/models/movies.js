import mongoose from 'mongoose';

const MovieSchema = new mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    actor_facets: String,
    actors: String,
    alternative_titles: String,
    color: String,
    genre: String,
    objectID: String,
    image: String,
    rating: Number,
    title: String,
    score: Number,
    year: Number
});

const Movie = mongoose.model('Movie', MovieSchema);

export default Movie;
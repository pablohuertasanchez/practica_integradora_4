import Movie from '@/models/movies';

async function obtenerPeliculas() {
    try {
        const movies = await Movie.find();
        return movies;
    } catch (error) {
        console.error(error);
        return null;
    }
}

export { obtenerPeliculas };
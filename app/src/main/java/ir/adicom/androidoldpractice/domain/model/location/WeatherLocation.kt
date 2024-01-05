package ir.adicom.androidoldpractice.domain.model.location

data class WeatherLocation(
    var id: Long = 0,
    var cityName: String = "",
    var userId: Long = 0
)

//fun WeatherLocation.toEntity(): WeatherLocationDto = WeatherLocationDto(id, cityName, userId)
package intern.line.me.kyotoaclient.lib.api.interfaces


import intern.line.me.kyotoaclient.model.entity.User
import retrofit2.Call
import retrofit2.http.*


interface UserAPI{

    @POST("/users")
    fun createUser(
            @Query("name") name: String,
            @Header("Token") token : String

    ) : Call<User>

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUserInfoById(@Path("id")id: Long): Call<User>

    @GET("/users/me")
    fun getMyInfo(@Header("Token") Token: String): Call<User>

    @PUT("/users/me")
    fun changeUserInfo(@Header("Token") Token: String, @Query("name")name: String): Call<User>

    @GET("/users/search")
    fun searchUsers(@Query("name")name: String): Call<List<User>>
}

package brianmccabe.openweathermap.data;


import brianmccabe.openweathermap.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RestServiceProvider {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static Retrofit.Builder builder =
         new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}

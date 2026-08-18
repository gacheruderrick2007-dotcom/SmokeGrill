package com.example.Derrick.data.remote

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.auth.Auth

object SupabaseClient {
    private const val SUPABASE_URL = "https://ytdakrtmsmuvjfrxbbos.supabase.co"
    private const val SUPABASE_KEY = "sb_publishable_WxD9IfjGeElpDZPXiQkfUw_wGzVfrkr"

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Postgrest)
        install(Auth)
    }
}

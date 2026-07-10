package mx.utng.srcp.smarthealthmonitor.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import mx.utng.srcp.smarthealthmonitor.tv.presentation.TvCatalogScreen
import mx.utng.srcp.smarthealthmonitor.tv.ui.theme.SmarthealthmonitorTvTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmarthealthmonitorTvTheme {
                Surface(
                    shape = MaterialTheme.shapes.medium
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "catalog") {
                        composable("catalog") {
                            TvCatalogScreen()
                        }
                    }
                }
            }
        }
    }
}

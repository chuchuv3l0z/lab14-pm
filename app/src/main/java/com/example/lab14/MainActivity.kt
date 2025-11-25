package com.example.lab14

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab14.ui.theme.BaldositaTheme
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaldositaTheme {
                DashboardScreen()
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        // Header
        HeaderSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta principal de energía
        EnergyCard()

        Spacer(modifier = Modifier.height(24.dp))

        // Mini gráfico decorativo
        MiniChartSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Zonas activas
        ActiveZonesSection()

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de estadísticas
        StatsButton()
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "⚡",
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "BALDOSITA",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00E5FF)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Smart Energy Floor",
            fontSize = 14.sp,
            color = Color(0xFF64B5F6)
        )
    }
}

@Composable
fun EnergyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(12.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E2442)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ENERGÍA GENERADA HOY",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF9FA8DA),
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "0.82",
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF76FF03)
            )

            Text(
                text = "kWh",
                fontSize = 18.sp,
                color = Color(0xFFB0BEC5)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(label = "Ayer", value = "0.71 kWh")
                StatItem(label = "Semana", value = "5.2 kWh")
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 11.sp,
            color = Color(0xFF9FA8DA)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Composable
fun MiniChartSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F3A)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Últimas 7 horas",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Mini barras decorativas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                MiniBar(height = 30.dp)
                MiniBar(height = 45.dp)
                MiniBar(height = 38.dp)
                MiniBar(height = 52.dp)
                MiniBar(height = 48.dp)
                MiniBar(height = 42.dp)
                MiniBar(height = 55.dp)
            }
        }
    }
}

@Composable
fun MiniBar(height: Dp) {
    Box(
        modifier = Modifier
            .width(32.dp)
            .height(height)
            .background(
                color = Color(0xFF76FF03),
                shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
            )
    )
}

@Composable
fun ActiveZonesSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Zonas Activas",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        ZoneItem(name = "Pasillo principal", energy = "0.32 kWh")
        Spacer(modifier = Modifier.height(8.dp))
        ZoneItem(name = "Entrada", energy = "0.28 kWh")
        Spacer(modifier = Modifier.height(8.dp))
        ZoneItem(name = "Sala de estar", energy = "0.22 kWh")
    }
}

@Composable
fun ZoneItem(name: String, energy: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F3A)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📍",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = name,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }

            Text(
                text = energy,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF76FF03)
            )
        }
    }
}

@Composable
fun StatsButton() {
    val context = LocalContext.current

    Button(
        onClick = {
            val intent = Intent(context, WorkActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(12.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7C4DFF)
        )
    ) {
        Text(
            text = "Ver Estadísticas →",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    BaldositaTheme {
        DashboardScreen()
    }
}
package com.example.lab14

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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


class WorkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaldositaTheme {
                StatsScreen()
            }
        }
    }
}

@Composable
fun StatsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        // Header
        StatsHeader()

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta de resumen
        SummaryCard()

        Spacer(modifier = Modifier.height(24.dp))

        // Gráfico decorativo
        DecorativeChart()

        Spacer(modifier = Modifier.height(24.dp))

        // Métricas rápidas
        QuickMetricsSection()

        Spacer(modifier = Modifier.height(32.dp))

        // Botón volver
        BackButton()
    }
}

@Composable
fun StatsHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "📈",
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Estadísticas",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7C4DFF)
        )
    }
}

@Composable
fun SummaryCard() {
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
                .padding(24.dp)
        ) {
            Text(
                text = "RESUMEN GENERAL",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF9FA8DA),
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryMetric(
                    label = "Total Generado",
                    value = "12.4",
                    unit = "kWh",
                    color = Color(0xFF76FF03)
                )

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(60.dp)
                        .background(Color(0xFF3A4266))
                )

                SummaryMetric(
                    label = "Promedio Diario",
                    value = "0.86",
                    unit = "kWh/día",
                    color = Color(0xFF00E5FF)
                )
            }
        }
    }
}

@Composable
fun SummaryMetric(label: String, value: String, unit: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFF9FA8DA)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = value,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = unit,
                fontSize = 14.sp,
                color = Color(0xFFB0BEC5),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun DecorativeChart() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F3A)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Últimos 14 días",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFF76FF03), CircleShape)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "+18%",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0A0E27)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Gráfico de línea decorativo falso
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                ChartBar(height = 45.dp, color = Color(0xFF7C4DFF))
                ChartBar(height = 52.dp, color = Color(0xFF7C4DFF))
                ChartBar(height = 38.dp, color = Color(0xFF7C4DFF))
                ChartBar(height = 68.dp, color = Color(0xFF00E5FF))
                ChartBar(height = 75.dp, color = Color(0xFF00E5FF))
                ChartBar(height = 62.dp, color = Color(0xFF00E5FF))
                ChartBar(height = 58.dp, color = Color(0xFF76FF03))
                ChartBar(height = 85.dp, color = Color(0xFF76FF03))
                ChartBar(height = 92.dp, color = Color(0xFF76FF03))
                ChartBar(height = 78.dp, color = Color(0xFF76FF03))
                ChartBar(height = 88.dp, color = Color(0xFF76FF03))
                ChartBar(height = 95.dp, color = Color(0xFF76FF03))
                ChartBar(height = 90.dp, color = Color(0xFF76FF03))
                ChartBar(height = 100.dp, color = Color(0xFF76FF03))
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hace 14d",
                    fontSize = 10.sp,
                    color = Color(0xFF9FA8DA)
                )
                Text(
                    text = "Hoy",
                    fontSize = 10.sp,
                    color = Color(0xFF9FA8DA)
                )
            }
        }
    }
}

@Composable
fun ChartBar(height: Dp, color: Color) {
    Box(
        modifier = Modifier
            .width(18.dp)
            .height(height)
            .background(
                color = color,
                shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
            )
    )
}

@Composable
fun QuickMetricsSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Métricas Rápidas",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        MetricCard(
            icon = "🏆",
            title = "Zona más activa",
            value = "Pasillo principal",
            subtitle = "38% del total"
        )

        Spacer(modifier = Modifier.height(10.dp))

        MetricCard(
            icon = "📅",
            title = "Día con mayor generación",
            value = "Viernes 15 Nov",
            subtitle = "1.24 kWh generados"
        )

        Spacer(modifier = Modifier.height(10.dp))

        MetricCard(
            icon = "⏰",
            title = "Horario pico",
            value = "18:00 - 20:00",
            subtitle = "Mayor actividad registrada"
        )
    }
}

@Composable
fun MetricCard(icon: String, title: String, value: String, subtitle: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F3A)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFF1E2442), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = Color(0xFF9FA8DA)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    fontSize = 11.sp,
                    color = Color(0xFFB0BEC5)
                )
            }
        }
    }
}

@Composable
fun BackButton() {
    val activity = LocalContext.current as? Activity

    Button(
        onClick = {
            activity?.finish()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(12.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00ACC1)
        )
    ) {
        Text(
            text = "← Volver al Dashboard",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StatsPreview() {
    BaldositaTheme {
        StatsScreen()
    }
}
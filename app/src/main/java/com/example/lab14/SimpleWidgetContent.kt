package com.example.lab14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.lab14.MainActivity
import com.example.lab14.WorkActivity

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            // Usamos GlanceTheme para obtener ColorProvider sin crearlo a mano
            GlanceTheme {
                WidgetContent()
            }
        }
    }

    @Composable
    private fun WidgetContent() {
        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(1.dp)
        ) {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color(0xFF0A0E27)) // fondo directo con Color
                    .cornerRadius(16.dp)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalAlignment = Alignment.Top
            ) {
                // Header
                Box(
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .background(Color(0xFF1A1F3A))
                        .cornerRadius(12.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "⚡ BALDOSITA",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = GlanceTheme.colors.primary   // ColorProvider interno ✅
                            )
                        )
                        Spacer(modifier = GlanceModifier.height(2.dp))
                        Text(
                            text = "Smart Energy Floor",
                            style = TextStyle(
                                fontSize = 11.sp,
                                color = GlanceTheme.colors.secondary // ✅
                            )
                        )
                    }
                }

                Spacer(modifier = GlanceModifier.height(18.dp))

                // Card de energía
                Box(
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .background(Color(0xFF1E2442))
                        .cornerRadius(12.dp)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "HOY",
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = GlanceTheme.colors.secondary
                            )
                        )
                        Spacer(modifier = GlanceModifier.height(6.dp))
                        Text(
                            text = "0.82",
                            style = TextStyle(
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                                color = GlanceTheme.colors.tertiary   // un color llamativo
                            )
                        )
                        Text(
                            text = "kWh generados",
                            style = TextStyle(
                                fontSize = 13.sp,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                    }
                }

                Spacer(modifier = GlanceModifier.height(12.dp))

                // Zona activa
                Box(
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .background(Color(0xFF1A1F3A))
                        .cornerRadius(8.dp)
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = GlanceModifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "📍",
                            style = TextStyle(fontSize = 14.sp)
                        )
                        Spacer(modifier = GlanceModifier.width(6.dp))
                        Text(
                            text = "Pasillo principal",
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                    }
                }

                Spacer(modifier = GlanceModifier.height(18.dp))

                // Botones de acción premium
                Row(
                    modifier = GlanceModifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Dashboard
                    Box(
                        modifier = GlanceModifier
                            .background(Color(0xFF00ACC1))
                            .cornerRadius(10.dp)
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                            .clickable(onClick = actionStartActivity<MainActivity>()),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "📊 Dashboard",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                    }

                    Spacer(modifier = GlanceModifier.width(12.dp))

                    // Stats
                    Box(
                        modifier = GlanceModifier
                            .background(Color(0xFF7C4DFF))
                            .cornerRadius(10.dp)
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                            .clickable(onClick = actionStartActivity<WorkActivity>()),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "📈 Stats",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = GlanceTheme.colors.onPrimary
                            )
                        )
                    }
                }
            }
        }
    }
}

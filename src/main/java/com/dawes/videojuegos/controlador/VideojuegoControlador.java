package com.dawes.videojuegos.controlador;

import com.dawes.videojuegos.DTO.videojuegosDTO;
import com.dawes.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
@Controller
@RequestMapping("/videojuegos")
public class VideojuegoControlador {

		private final VideojuegoService videojuegoService;
		public VideojuegoControlador(VideojuegoService videojuegoService, VideojuegoService videojuegoService1) {
			this.videojuegoService = videojuegoService1;

		}
		@GetMapping("/listadoVideojuegos")
		public String listadoVideojuegos(Model model) throws SQLException {
			ArrayList<videojuegosDTO> listaVideojuegos =
					videojuegoService.buscarVideojuegos( null , " "  , null ,  null , null , null);


			model.addAttribute("listaVideojuegos", listaVideojuegos);
			return "videojuegos/listado";
		}
		@PostMapping("/listadoVideojuegos")
		public String buscarVideojuegos(@RequestParam Integer id,
		                            @RequestParam String titulo,
		                            @RequestParam Integer id_Desarrolladora,
		                            @RequestParam Integer fechaLanzamiento,
		                                @RequestParam Integer pegiMax,
		                                @RequestParam Integer Copias,


		                            Model model) throws SQLException {

			ArrayList<videojuegosDTO> listaVideojuegos =
					videojuegoService.buscarVideojuegos(id, titulo , id_Desarrolladora , fechaLanzamiento , pegiMax , Copias);
			model.addAttribute("listaVideojuegos", listaVideojuegos);
			return "videojuegos/listado";
		}}



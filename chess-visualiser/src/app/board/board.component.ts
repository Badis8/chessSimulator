import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ChessService } from '../chess.service';
@Component({
  selector: 'app-board',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent { 
  public chessBoard: { [row: number]: { [col: string]: any; }; } = [];
  constructor(private  chessService: ChessService) { 
 
    this.chessBoard = this.chessService.chessBoard; 
    console.log(this.chessBoard); 
    this.chessService.randomMovesLoop();
      
  }
 
  rows: number[] = [8, 7, 6, 5, 4, 3, 2, 1];
  
  letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'];  
  boxes = Array(64).fill(0);  
  generateId(index: number): string {
    const row = this.rows[Math.floor(index / this.letters.length)]; 
    const letter = this.letters[index % this.letters.length]; 
    return `${letter}${row}`; 
  } 
  getRow(index: number): number {
    return this.rows[Math.floor(index / this.letters.length)];
  }

  getColumn(index: number): string {
    return this.letters[index % this.letters.length];
  }
}

import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent {
  letters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];  
  boxes = Array(64).fill(0);  
  generateId(index: number): string {
    const row = Math.floor(index / this.letters.length) + 1;  
    const letter = this.letters[index % this.letters.length]; 
    return `${letter}${row}`; 
  }
}

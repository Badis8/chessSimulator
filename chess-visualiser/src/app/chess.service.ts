import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChessService {
  public chessBoard: { [row: number]: { [col: string]: any } } = {};
  private columns = 'abcdefgh';

  constructor() {
    this.initializeBoard()
   }   

  movePiece(fromRow: number, fromCol: string, toRow: number, toCol: string){ 
    const piece = this.chessBoard[fromRow][fromCol];
    this.chessBoard[toRow][toCol] = piece;
    this.chessBoard[fromRow][fromCol] = null;

  } 

  private initializeBoard() {
    const columns = 'abcdefgh';

 
    for (let row = 1; row <= 8; row++) {
      this.chessBoard[row] = {};
      for (const col of columns) {
        this.chessBoard[row][col] = null;
      }
    }
 
    for (const col of columns) {
      this.chessBoard[2][col] = 'P';  
      this.chessBoard[7][col] = 'p'; 
    }

 
    this.chessBoard[1]['a'] = this.chessBoard[1]['h'] = 'R';  
    this.chessBoard[8]['a'] = this.chessBoard[8]['h'] = 'r';  

  
    this.chessBoard[1]['b'] = this.chessBoard[1]['g'] = 'N';  
    this.chessBoard[8]['b'] = this.chessBoard[8]['g'] = 'n';  

  
    this.chessBoard[1]['c'] = this.chessBoard[1]['f'] = 'B';  
    this.chessBoard[8]['c'] = this.chessBoard[8]['f'] = 'b';  

   
    this.chessBoard[1]['d'] = 'Q';  
    this.chessBoard[8]['d'] = 'Q';  
    this.chessBoard[1]['e'] = 'K';  
    this.chessBoard[8]['e'] = 'k';   
 
  } 
  randomMove(): void {
    const pieces = this.getAllPieces();
    
    if (pieces.length === 0) return;

    const randomPiece = pieces[Math.floor(Math.random() * pieces.length)];
    const { row, col, piece } = randomPiece;

    const possibleMoves = this.getPossibleMoves(row, col);

    if (possibleMoves.length === 0) return;

    const randomMove = possibleMoves[Math.floor(Math.random() * possibleMoves.length)];
    const { toRow, toCol } = randomMove;

    console.log(`Moving ${piece} from ${col}${row} to ${toCol}${toRow}`);
    this.movePiece(row, col, toRow, toCol);
  }

  async randomMovesLoop(): Promise<void> {
    while (true) {
      this.randomMove();
      await this.wait(1000);
    }
  } 
  private getAllPieces(): { row: number; col: string; piece: string }[] {
    const pieces = [];
    for (const row in this.chessBoard) {
      for (const col in this.chessBoard[row]) {
        const piece = this.chessBoard[row][col];
        if (piece) {
          pieces.push({ row: parseInt(row, 10), col, piece });
        }
      }
    }
    return pieces;
  }

  private getPossibleMoves(row: number, col: string): { toRow: number; toCol: string }[] {
    const moves = [];
    const directions = [-1, 1];

    for (const direction of directions) {
      const newRow = row + direction;
      if (newRow >= 1 && newRow <= 8) {
        moves.push({ toRow: newRow, toCol: col });
      }
    }

    for (const direction of directions) {
      const newCol = String.fromCharCode(col.charCodeAt(0) + direction);
      if (this.columns.includes(newCol)) {
        moves.push({ toRow: row, toCol: newCol });
      }
    }

    return moves.filter(move => !this.chessBoard[move.toRow][move.toCol]);
  }

  private wait(ms: number): Promise<void> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
}

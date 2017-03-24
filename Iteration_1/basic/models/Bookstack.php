<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "book_stack".
 *
 * @property string $bookID
 * @property string $price
 * @property string $quantity
 * @property string $book_name
 *
 * @property BookDetail $bookDetail
 * @property Shipment[] $shipments
 * @property Indent[] $indents
 */
class Bookstack extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'book_stack';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['bookID'], 'required'],
            [['bookID', 'price', 'quantity'], 'number'],
            [['book_name'], 'string', 'max' => 50],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'bookID' => 'Book ID',
            'price' => 'Price',
            'quantity' => 'Quantity',
            'book_name' => 'Book Name',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getBookDetail()
    {
        return $this->hasOne(BookDetail::className(), ['bookID' => 'bookID']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getShipments()
    {
        return $this->hasMany(Shipment::className(), ['bookID' => 'bookID']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getIndents()
    {
        return $this->hasMany(Indent::className(), ['indentID' => 'indentID'])->viaTable('shipment', ['bookID' => 'bookID']);
    }
}

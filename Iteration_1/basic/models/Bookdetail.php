<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "book_detail".
 *
 * @property string $bookID
 * @property string $writer
 * @property string $press
 * @property string $picture
 *
 * @property BookStack $book
 */
class Bookdetail extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'book_detail';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['bookID'], 'required'],
            [['bookID'], 'number'],
            [['writer', 'press'], 'string', 'max' => 50],
            [['picture'], 'string', 'max' => 1],
            [['bookID'], 'exist', 'skipOnError' => true, 'targetClass' => BookStack::className(), 'targetAttribute' => ['bookID' => 'bookID']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'bookID' => 'Book ID',
            'writer' => 'Writer',
            'press' => 'Press',
            'picture' => 'Picture',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getBook()
    {
        return $this->hasOne(BookStack::className(), ['bookID' => 'bookID']);
    }
}
